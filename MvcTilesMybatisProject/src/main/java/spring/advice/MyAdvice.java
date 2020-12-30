package spring.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class MyAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
//    public String handleRuntimeException(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
    public String handleRuntimeException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        System.out.println("exceptionCatch");
        e.printStackTrace();
        request.getSession().setAttribute("error", e.getMessage());
        return "/error/imguploaderrorpage";
    }
}
