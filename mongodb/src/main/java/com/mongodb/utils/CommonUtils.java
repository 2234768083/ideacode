package com.mongodb.utils;

import javax.servlet.http.HttpServletRequest;

public class CommonUtils {

    public final static String ERROR_IP = "127.0.0.1";

    public static String getUserIP(HttpServletRequest request) {
        // 优先取 X-Real-IP
        String ip = request.getHeader("X-Real-IP"); // 获取请求头中的 X-Real-IP
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { // 如果 X-Real-IP 为空、长度为0或者等于 "unknown"，则继续获取其他 IP
            ip = request.getHeader("x-forwarded-for"); // 获取请求头中的 x-forwarded-for
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { // 如果 ip 为空、长度为0或者等于 "unknown"，则获取远程地址
            ip = request.getRemoteAddr(); // 获取远程地址
            if ("0:0:0:0:0:0:0:1".equals(ip)) { // 如果远程地址为 "0:0:0:0:0:0:0:1"，则设置 ip 为 ERROR_IP
                ip = ERROR_IP;
            }
        }
        if ("unknown".equalsIgnoreCase(ip)) { // 如果 ip 等于 "unknown"，则设置 ip 为 ERROR_IP 并返回 ip
            ip = ERROR_IP;
            return ip;
        }
        int index = ip.indexOf(','); // 查找 ip 中的逗号索引
        if (index >= 0) { // 如果逗号索引大于等于0，则截取逗号前面的部分作为 ip
            ip = ip.substring(0, index);
        }

        return ip; // 返回 ip
    }


}
