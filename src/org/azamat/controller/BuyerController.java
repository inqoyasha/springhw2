package org.azamat.controller;

import org.azamat.model.Buyer;
import org.azamat.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createBook(@RequestBody Buyer buyer){
        buyerService.add(buyer);
    }

    @GetMapping ("/find")
    public ResponseEntity<Buyer> findById(@RequestParam int id){
        Buyer buyer = buyerService.findById(id);

        if (buyer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(buyer);
        }
    }

    @DeleteMapping ("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable int id){
        buyerService.removeById(id);
    }

    @PutMapping("/replace/{id}")
    public ResponseEntity<Buyer> replaceBook(@PathVariable int id,
                                             @RequestBody Buyer buyer){
        buyerService.fullUpdateById(id, buyer);


        if (buyerService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(buyerService.findById(id));
        }

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Buyer> updateBook(@PathVariable int id,
                                            @PathVariable int sale) {

        buyerService.updateById(id, sale);

        if (buyerService.findById(id) == null){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        else {
            return ResponseEntity.ok(buyerService.findById(id));
        }

    }

    @GetMapping("/find/all")
    public List<Buyer> findAll() {
        return buyerService.findAll();
    }


}

