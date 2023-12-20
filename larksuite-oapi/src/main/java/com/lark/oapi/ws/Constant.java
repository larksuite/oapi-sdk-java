package com.lark.oapi.ws;

public class Constant {
    public static final String GEN_ENDPOINT_URI = "/callback/ws/endpoint";
    public static final String DEVICE_ID = "device_id";
    public static final String SERVICE_ID = "service_id";

    // ErrorCode
    public static final int OK = 0;
    public static final int SYSTEM_BUSY = 1;
    public static final int FORBIDDEN = 403;
    public static final int AUTH_FAILED = 514;
    public static final int INTERNAL_ERROR = 1000040343;
    public static final int EXCEED_CONN_LIMIT = 1000040350;

    // Header
    public static final String HEADER_TYPE = "type";
    public static final String HEADER_MESSAGE_ID = "message_id";
    public static final String HEADER_SUM = "sum";
    public static final String HEADER_SEQ = "seq";
    public static final String HEADER_TRACE_ID = "trace_id";
    public static final String HEADER_BIZ_RT = "biz_rt";
    public static final String HEADER_HANDSHAKE_STATUS = "handshake-status";
    public static final String HEADER_HANDSHAKE_MSG = "handshake-msg";
    public static final String HEADER_HANDSHAKE_AUTH_ERRCODE = "handshake-autherrcode";
}
