package com.cedricxs.application.advisor;

import com.cedricxs.application.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chaxingshuo
 * @date 2021/07/11
 */
@Slf4j
@ControllerAdvice
public class CommentAdvisor {

    @ExceptionHandler(RepositoryException.class)
    public ModelAndView repositoryExceptionHandler(RepositoryException repositoryException) {
        log.error("Repository Exception caught.", repositoryException);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
