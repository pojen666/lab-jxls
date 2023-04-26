package com.demo;

import com.demo.service.JxlsService;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileOutputStream;
import java.io.OutputStream;

@SpringBootTest
class JxlsServiceTest {

    @Resource
    private JxlsService jxlsService;

    @SneakyThrows
    @Test
    void test() {
        try (OutputStream outputStream = new FileOutputStream("target/simple-demo.xlsx")) {
            jxlsService.write(outputStream);
        }
    }
}
