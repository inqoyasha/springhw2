package org.azamat;

        import org.azamat.service.BookService;
        import org.azamat.service.BuyerService;
        import org.azamat.service.PurchaseService;
        import org.azamat.service.ShopService;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootStarter implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringBootStarter.class);

    @Autowired
    private BookService bookService;
    @Autowired
    private BuyerService buyerService;
    @Autowired
    private ShopService shopService;
    @Autowired
    private PurchaseService purchaseService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarter.class, args);
    }

    @Override
    public void run(String... args) {
//-------------------------------------------------1--------------------------------------------------------------------
//        log.info("book find all");
//        bookService.findAll().forEach(System.out::println);
//
//        log.info("book find by id");
//        System.out.println(bookService.findById(2));
//
//        log.info("book remove by id");
//        bookService.removeById(1);
//        bookService.findAll().forEach(System.out::println);
//
//        log.info("add new book");
//        bookService.add(new Book("Alisa", 12.2, "storage1", 2));
//
//        log.info("update book by id");
//        bookService.updateById(1, 13.2, 2, "storage8").forEach(System.out::println);
//
//        log.info("full update book by id");
//        bookService.fullUpdateById(1, new Book("tvari", 32.33, "storage12", 34)).forEach(System.out::println);

//----------------------------------------------------1-----------------------------------------------------------------
//        log.info("add new");
//        purchaseService.add(new Purchase(1, Calendar.getInstance().getTime(), shopService.findById(2), buyerService.findById(2), bookService.findById(2), 1, 13));
//
//        log.info("find all");
//        purchaseService.findAll().forEach(System.out::println);
//
//        log.info("find by id");
//        System.out.println(purchaseService.findById(2));
//
//        log.info("remove by id");
//        purchaseService.removeById(1);
//        purchaseService.findAll().forEach(System.out::println);
//
//        log.info("add new");
//        purchaseService.add(new Purchase(1, Calendar.getInstance().getTime(), shopService.findById(1), buyerService.findById(3), bookService.findById(1), 1, 13));
//        purchaseService.findAll().forEach(System.out::println);
//
//        log.info("update by id");
//        purchaseService.updateById(2, 2, 1233).forEach(System.out::println);
//
//        log.info("full update by id");
//        purchaseService.fullUpdateById(3, new Purchase(9, Calendar.getInstance().getTime(), new Shop(), new Buyer(), new Book(), 3, 12223)).forEach(System.out::println);
//----------------------------------------------------2-----------------------------------------------------------------
//        log.info("all book name and cost");
//        bookService.findAllBooks().forEach(System.out::println);
//        log.info("all bbuyer address");
//        buyerService.findAllBuyerAddress().forEach(System.out::println);
//        log.info("all purchase month");
//        purchaseService.findAllPurchaseByMonth().forEach(System.out::println);
//----------------------------------------------------3-----------------------------------------------------------------
//        log.info("lastName and discount by address");
//        buyerService.findLastNameAmdDiscountByAddress().forEach(System.out::println);
//        log.info("lastName and discount by address");
//        buyerService.findLastNameAndDiscountByAddressLike("dzerzhinsk").forEach(System.out::println);
//        log.info("ShopName by address");
//        shopService.findShopNameByAddressStartsWith("a").forEach(System.out::println);
//        log.info("bookname and cost by name 'alisa' or cost > 500");
//        bookService.findBookNameAndCostByBookNameLikeOrCostGreaterThan("Alisa", 500.0).forEach(System.out::println);
//----------------------------------------------------4-----------------------------------------------------------------
//        log.info("shopname and lastname on purchase");
//        purchaseService.findLastNameAndShopName().forEach(System.out::println);
//        log.info("date,lastname,discount on buyer");
//        purchaseService.findDateLastNameDiscountBookNameQuantity().forEach(System.out::println);
//----------------------------------------------------5-----------------------------------------------------------------
//        log.info("date,lastname,order_id by sum > 1201");
//        purchaseService.findIdLastNameDateBySum().forEach(System.out::println);
//        log.info("date,lastname,address by shop address");
//        purchaseService.findLastNameAddressDateByAddress().forEach(System.out::println);
//        log.info("shopname,lastname,discount by shop discount between 10 and 15");
//        purchaseService.findShopNameByAddressAndDiscount().forEach(System.out::println);
        log.info("storagename,address,quantity, cost by quantityStorage");
        purchaseService.findStorageNameByQuantity().forEach(System.out::println);
    }
}

