package org.example.web.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.common.BusinessException;
import org.example.common.constant.RespInfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyBlockExceptionHandler implements BlockExceptionHandler {
    public MyBlockExceptionHandler() {
    }

    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        throw new BusinessException(RespInfo.HTTP_ERROR.getCode(), e.getRule().getClass().getName() + ":被限流");
        /*response.setStatus(HttpStatus.SC_OK);
        PrintWriter out = response.getWriter();
        response.setCharacterEncoding("UTF-8");
        response.setContentType(ContentType.APPLICATION_JSON.toString());
        RespBean<String> respBean = new RespBean<>();
        respBean.setCode(RespInfo.HTTP_ERROR.getCode());
        respBean.setMsg("被限流");
        out.print(JSON.toJSONString(respBean));
        out.flush();
        out.close();*/
    }
}
