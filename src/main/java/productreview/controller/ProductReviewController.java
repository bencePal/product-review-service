package productreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductReviewController {

    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    public String test(Model model) {
        return "index";

    }
}
