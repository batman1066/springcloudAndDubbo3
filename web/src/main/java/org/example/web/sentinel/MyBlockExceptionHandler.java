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
        String message = "rest server Blocked by Sentinel: " + e.getClass().getSimpleName();
        BusinessException businessException = new BusinessException(RespInfo.HTTP_ERROR.getCode(), message, true);
        throw businessException;
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
