package org.azamat.controller;

import org.azamat.model.Shop;
import org.azamat.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBook(@RequestBody Shop shop){
        shopService.add(shop);
    }

    @GetMapping ("/find")
    public ResponseEntity<Shop> findById(@RequestParam int id){
        Shop shop = shopService.findById(id);

        if (shop == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(shop);
        }
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable int id){
        shopService.removeById(id);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Shop> replaceBook(@PathVariable int id,
                                            @RequestBody Shop shop){
        shopService.fullUpdateById(id, shop);


        if (shopService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(shopService.findById(id));
        }

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Shop> updateBook(@PathVariable int id,
                                           @RequestParam String name,
                                           @RequestParam int commission){

        shopService.updateById(id, name, commission);

        if (shopService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(shopService.findById(id));
        }

    }

    @GetMapping("/find/all")
    public List<Shop> findAll() {
        return shopService.findAll();
    }


}