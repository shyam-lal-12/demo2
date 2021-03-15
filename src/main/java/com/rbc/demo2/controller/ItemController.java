package com.rbc.demo2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/recommendations")
public class ItemController {

    // log.info("Inside ItemController.");

    // @Autowired
    // private ItemService service;

    // @RequestMapping(value = "", method = RequestMethod.GET)
    // // @Cacheable("recommendations")
    // public List<Item> list() {
    //     return service.listAll();
    // }

    // @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    // // @Cacheable(value = "recommendations", key = "#userId")
    // public Item getItem(@PathVariable("userId") Integer userId) {

    //     if(!userIdCheck(userId)) throw new ItemNotFoundException();
    //     return service.get(userId);

    // }

    // @RequestMapping(value = "/add-items", method = RequestMethod.POST)
    // public List<Item> add(@RequestBody Item item) {
    //     service.save(item);
    //     return service.listAll();
    // }

    // @RequestMapping(value = "remove-item/{itemId}", method = RequestMethod.DELETE)
    // public void deleteItem(@PathVariable("itemId") Integer itemId) {
    //     if(!userIdCheck(itemId)) throw new ItemNotFoundException();
    //     service.delete(itemId);
    // }

    // private boolean userIdCheck(Integer userId){
    //     var allItems = service.listAll();
    //     var itemMap = allItems.stream().collect(Collectors.toMap(Item::getId, item -> item));
    //     if (!itemMap.containsKey(userId))
    //         return false;
    //     return true;
    // }
}
