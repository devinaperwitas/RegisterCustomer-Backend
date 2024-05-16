package id.co.sisteminformasiregistercustomerbackend.service.impl;

import id.co.sisteminformasiregistercustomerbackend.repository.PolmanAstraRepository;
import id.co.sisteminformasiregistercustomerbackend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    PolmanAstraRepository polmanAstraRepository;

    @Override
    public String getDataRegister(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("reg_getAllData", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getDataRegisterById(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("reg_getDataById", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String createRegister(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("reg_createRegister", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String detailRegister(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_detailProses", dataList.toArray(new String[0]));
        return result;
    }

//    @Override
//    public String editRegister(Map<String, Object> data) {
//        List<String> dataList = new ArrayList<>();
//        for (Map.Entry<String, Object> entry : data.entrySet()) {
//            dataList.add(entry.getValue().toString());
//        }
//        String result = polmanAstraRepository.callProcedure("pro_editProses", dataList.toArray(new String[0]));
//        return result;
//    }

    @Override
    public String setStatusRegister(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_setStatusProses", dataList.toArray(new String[0]));
        return result;
    }

    @Override
    public String getListRegister(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("pro_getListProses", dataList.toArray(new String[0]));
        return result;
    }
}
