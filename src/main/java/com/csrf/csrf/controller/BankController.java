package com.csrf.csrf.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
public class BankController {

    @GetMapping("/transfer")
    @ResponseBody
    public String transfer(@RequestParam("accountNo") int accountNo,
                           @RequestParam("amount") final int amount,
                           @RequestParam("_csrf") final String _csrf) {
        log.info("Transfer {} to {}", amount, accountNo);
        return "Transfer "+amount+" to "+accountNo;
    }

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public void transfer2(@RequestParam("accountNo") int accountNo,
                          @RequestParam("amount") final int amount,
                          @RequestParam("_csrf") final String _csrf) {
        log.info("Transfer {} to {}", amount, accountNo);
    }
}
