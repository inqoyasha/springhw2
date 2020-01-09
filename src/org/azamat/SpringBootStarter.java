package org.azamat;

        import org.azamat.model.Book;
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

        log.info("book find all");
        bookService.findAll().forEach(System.out::println);

        log.info("book find by id");
        System.out.println(bookService.findById(2));

        log.info("book remove by id");
        bookService.removeById(1);
        bookService.findAll().forEach(System.out::println);

        log.info("add new book");
        bookService.add(new Book("Alisa", 12.2, "storage1", 2));

        log.info("update book by id");
        bookService.updateById(1, 13.2, 2, "storage8").forEach(System.out::println);

        log.info("full update book by id");
        bookService.fullUpdateById(1, new Book("tvari", 32.33, "storage12", 34)).forEach(System.out::println);

    }
}

