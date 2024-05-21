package id.co.sisteminformasiregistercustomerbackend.service;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface RegisterService {
    String getDataRegister(Map<String, Object> data);
    String getDataRegisterById(Map<String, Object> data);
    String createRegister(Map<String, Object> data) throws JSONException;
    String detailRegister(Map<String, Object> data);
//    String editRegister(Map<String, Object> data);
    String setStatusRegister(Map<String, Object> data);
    String getListKodePos(Map<String, Object> data);
   // String createRegister(Map<String, Object> data, MultipartFile reg_berkas_nib, MultipartFile reg_berkas_npwp, MultipartFile reg_berkas_skt, MultipartFile reg_berkas_sppkp, MultipartFile reg_berkas_siup);
}

