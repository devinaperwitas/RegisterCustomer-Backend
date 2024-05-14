package id.co.sisteminformasiregistercustomerbackend.service;

import java.util.Map;

public interface RegisterService {
    String getDataRegister(Map<String, Object> data);
    String getDataRegisterById(Map<String, Object> data);
    String createRegister(Map<String, Object> data);
    String detailRegister(Map<String, Object> data);
//    String editRegister(Map<String, Object> data);
    String setStatusRegister(Map<String, Object> data);
    String getListRegister(Map<String, Object> data);
}

