package com.rbc.demo2.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbc.demo2.exceptionHandler.UserNotFoundException;
import com.rbc.demo2.model.Item;
import com.rbc.demo2.model.OrderItems;
import com.rbc.demo2.model.RatedItems;
import com.rbc.demo2.model.Rating;
import com.rbc.demo2.model.RecommendedItems;
import com.rbc.demo2.model.User;
import com.rbc.demo2.model.Wishlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
// @Transactional
public class UserRecommendationItemsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRecommendationItemsService.class);

	@Autowired
	private ObjectMapper mapper;

	public List<User> getAllActiveUserInfo() {
		LOGGER.info("Inside getAllActiveUserInfo method.");
		TypeReference<List<User>> typeReference_user = new TypeReference<List<User>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream("/json/users.json");

		List<User> users = new ArrayList<>();
		try {
			users = mapper.readValue(inputStream, typeReference_user);
			return users;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	public RecommendedItems getItemsRecommendations(Integer userId) {

		LOGGER.info("Inside getItemsRecommendations method.");
		RecommendedItems recomList = new RecommendedItems();
		try {

			List<RatedItems> myOrdersList = this.myOrdeList(userId);
			// set My-Orders list to recommended list
			recomList.setMyOrdersList(myOrdersList);
			// set My-Wish list to recommended list
			recomList.setMyWishlist(this.filteredWishList(userId));
			// set Other rated itemns to recommended list
			recomList.setRating(this.ratingsList(userId));
			return recomList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return recomList;
	}

	// method to get recommendation based on MY ORDERS LIST
	private List<RatedItems> myOrdeList(int userId) throws UsernameNotFoundException{
		LOGGER.info("Inside myOrdeList method.");
		TypeReference<List<OrderItems>> typeReference_orderItems = new TypeReference<List<OrderItems>>() {
		};
		InputStream inputStream_userItemsList = TypeReference.class.getResourceAsStream("/json/order-user-items.json");

		List<OrderItems> ordersList, myOrdersList = new ArrayList<>();
		List<RatedItems> ratedItems = new ArrayList<>();

		try {
			ordersList = mapper.readValue(inputStream_userItemsList, typeReference_orderItems);
			myOrdersList = ordersList.stream().filter(orders -> orders.getUser().getId() == userId)
					.collect(Collectors.toList());
			if(myOrdersList.isEmpty()|| myOrdersList==null) throw new UserNotFoundException();
			myOrdersList = myOrdersList.stream().filter(distinctByKey(OrderItems::getItem))
					.collect(Collectors.toList());
			ratedItems = myOrdersList.stream().map(rating -> {
				return setRatedItemsObject(rating.getItem(), rating.getRating());
			}).collect(Collectors.toList());

			// sorting based on the item rating
			ratedItems = ratedItems.stream().sorted(Comparator.comparing(RatedItems::getRating).reversed()).collect(Collectors.toList());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ratedItems;
	}

	// method to get recommendation based on MY WISH LIST
	private List<Item> filteredWishList(int userId) {

		LOGGER.info("Inside filteredWishList method.");
		// Reading json file from /resourses/json
		TypeReference<List<Wishlist>> typeReference_wishList = new TypeReference<List<Wishlist>>() {
		};
		InputStream inputStream_wishItems = TypeReference.class.getResourceAsStream("/json/wishlist.json");

		List<Wishlist> wishItems = new ArrayList<>();
		List<Wishlist> filteredWishList = new ArrayList<>();
		List<Item> myWishItems = new ArrayList<>();

		try {
			wishItems = mapper.readValue(inputStream_wishItems, typeReference_wishList);
			filteredWishList = wishItems.stream().filter(wishItem -> wishItem.getCustomerId() == userId)
					.collect(Collectors.toList());
			myWishItems = filteredWishList.stream().map(Wishlist::getItem).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myWishItems;

	}

	// method to get recommendation based on RATING
	private List<RatedItems> ratingsList(int userId) {

		LOGGER.info("Inside ratingsList method.");
		// Reading json file from /resourses/json
		TypeReference<List<Rating>> typeReference_rating = new TypeReference<List<Rating>>() {
		};
		InputStream inputStream_itemRatings = TypeReference.class.getResourceAsStream("/json/ratings.json");
		List<Rating> itemRatings = new ArrayList<>();
		List<RatedItems> ratedItems = new ArrayList<>();
		try {
			itemRatings = mapper.readValue(inputStream_itemRatings, typeReference_rating);
			// remove the items bought by {userId}
			List<Rating> otherCustomers = itemRatings.stream().filter(rating -> rating.getCustomerId() != userId)
					.collect(Collectors.toList());
			otherCustomers = otherCustomers.stream().filter(distinctByKey(Rating::getItem))
					.collect(Collectors.toList());
			ratedItems = otherCustomers.stream().map(rating -> {
				return setRatedItemsObject(rating.getItem(), rating.getRating());
			}).collect(Collectors.toList());
			// sorting based on the item rating
			ratedItems = ratedItems.stream().sorted(Comparator.comparing(RatedItems::getRating).reversed()).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ratedItems;

	}

	// utility function to finding all distinct objects by the field value
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
		Map<Object, Boolean> seen = new ConcurrentHashMap<>();
		return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Bean
	@Scope("prototype")
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	private RatedItems setRatedItemsObject(Item item, float rating) {
		LOGGER.info("Inside setRatedItemsObject method.");
		RatedItems ri = new RatedItems();
		ri.setItem(item);
		if (rating != 0f)
			ri.setRating(rating);
		return ri;
	}

	// @Bean
	// @Qualifier("User")
	// public TypeReference<List<?>> typeReference() {
	// return new TypeReference<List<?>>() {

	// };
	// }

}
