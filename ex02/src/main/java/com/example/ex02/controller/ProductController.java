package com.example.ex02.controller;

import com.example.ex02.domain.ProductVO;
import com.example.ex02.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class ProductController {

    private final ProductMapper productMapper;

    @GetMapping("register")
    public String register(Model model){
        model.addAttribute("productVO",new ProductVO());
        return "/product/product-register";
    }

    @PostMapping("register")
    public RedirectView register(ProductVO productVO){
        productMapper.insert(productVO);
        return new RedirectView("product/list");  // 다른 controller로 갈려면 redirect로 가야함. foward는 request방식을 유지하기때문에
                                        //요청한 경로가 그대로 남아있음, 하지만 redirect는 초기화하기때문에 기존경로 없어지고,
                                        //응답경로가 남아있음 그리고 ㄹredirect는 controller로 응답함
    }
    @GetMapping("list")
    public String list(Model model){
        model.addAttribute("products",productMapper.selectAll());
        return "/product/product-list";
    }
}
