package org.azamat.controller;

import org.azamat.model.Purchase;
import org.azamat.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBook(@RequestBody Purchase purchase){
        purchaseService.add(purchase);
    }

    @GetMapping ("/find")
    public ResponseEntity<Purchase> findById(@RequestParam int id){
        Purchase purchase = purchaseService.findById(id);

        if (purchase == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(purchase);
        }
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable int id){
        purchaseService.removeById(id);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Purchase> replaceBook(@PathVariable int id,
                                             @RequestBody Purchase purchase){
        purchaseService.fullUpdateById(id, purchase);


        if (purchaseService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(purchaseService.findById(id));
        }

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Purchase> updateBook(@PathVariable int id,
                                               @PathVariable int quantity,
                                               @PathVariable double sum) {

        purchaseService.updateById(id, quantity, sum);

        if (purchaseService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(purchaseService.findById(id));
        }

    }

    @GetMapping("/find/all")
    public List<Purchase> findAll() {
        return purchaseService.findAll();
    }


}