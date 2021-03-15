package com.rbc.demo2.controller;

import java.util.ArrayList;
import java.util.List;

import com.rbc.demo2.exceptionHandler.UserNotFoundException;
import com.rbc.demo2.model.RecommendedItems;
import com.rbc.demo2.model.User;
import com.rbc.demo2.service.UserRecommendationItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/recommendations")
public class RecommendationController {
	@Autowired
	private UserRecommendationItemsService userRecommendationItemsService;

	@GetMapping("/getAllUsers")
	@Cacheable(value = "getAllUsers")
	public Object getAllUser(@RequestHeader HttpHeaders requestHeader) {

		List<User> userInfos = new ArrayList<>();
		try {
			System.out.println("Going to sleep for 2 Secs.. to simulate backend call.");
			Thread.sleep(1000 * 2);
			userInfos = userRecommendationItemsService.getAllActiveUserInfo();
			if (userInfos == null || userInfos.isEmpty()) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userInfos;
	}

	@RequestMapping(value = "/{user-id}", method = RequestMethod.GET)
	@Cacheable(value = "recommendations")
	public Object getItemsRecommendations(@RequestHeader HttpHeaders requestHeader,
			@PathVariable("user-id") Integer userId) {

		RecommendedItems recommList = userRecommendationItemsService.getItemsRecommendations(userId);
		if (recommList.getMyOrdersList() == null) {
			throw new UserNotFoundException();

			// return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return recommList;

	}
}
