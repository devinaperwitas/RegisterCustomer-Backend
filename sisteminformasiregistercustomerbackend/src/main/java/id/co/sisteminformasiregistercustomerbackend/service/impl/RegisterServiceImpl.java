package id.co.sisteminformasiregistercustomerbackend.service.impl;

import id.co.sisteminformasiregistercustomerbackend.repository.PolmanAstraRepository;
import id.co.sisteminformasiregistercustomerbackend.service.RegisterService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
        String result = polmanAstraRepository.callProcedure("reg_getDataCustomer", dataList.toArray(new String[0]));
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
    public String createRegister(Map<String, Object> data) throws JSONException {

        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }

        System.out.println(dataList);
        String resultRegister = polmanAstraRepository.callProcedure("reg_createRegister", dataList.toArray(new String[0]));

        JSONArray jsonArray = new JSONArray(resultRegister);
        JSONObject jsonObject = jsonArray.getJSONObject(0); // Mengambil objek pertama dari array
        int hasil = jsonObject.getInt("hasil");
        String reg_id = String.valueOf(hasil);
        System.out.println("Result for reg_createRegister: " + hasil);

        List<Map<String, String>> lampirans = (List<Map<String, String>>) data.get("lampirans");
        for (Map<String, String> lampiran : lampirans) {
            // Membuat array parameter untuk pemanggilan stored procedure
            List<String> lampiranParams = new ArrayList<>();
            lampiranParams.add(reg_id);
            lampiranParams.add(lampiran.get("reg_berkas_nib"));
            lampiranParams.add(lampiran.get("reg_berkas_npwp"));
            lampiranParams.add(lampiran.get("reg_berkas_skt"));
            lampiranParams.add(lampiran.get("reg_berkas_sppkp"));
            lampiranParams.add(lampiran.get("reg_berkas_siup"));
            lampiranParams.add(data.get("creaby").toString());
            System.out.println(lampiranParams);
            // Memanggil stored procedure untuk setiap lampiran
            String result = polmanAstraRepository.callProcedure("reg_createLampiranRegister", lampiranParams.toArray(new String[0]));
            System.out.println("Result for lampiran " +
                    lampiran.get("reg_berkas_nib") + lampiran.get("reg_berkas_npwp") +
                    lampiran.get("reg_berkas_skt") + lampiran.get("reg_berkas_sppkp") +
                    lampiran.get("reg_berkas_siup") + ": " + result);
        }

        return resultRegister;
    }

   /* @Override
    public String createRegister(Map<String, Object> data,
                                 MultipartFile reg_berkas_nib, MultipartFile reg_berkas_npwp,
                                 MultipartFile reg_berkas_skt, MultipartFile reg_berkas_sppkp,
                                 MultipartFile reg_berkas_siup) {
        try {
            List<String> dataList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                dataList.add(entry.getValue().toString());
            }
            dataList.add(new String(reg_berkas_nib.getBytes()));
            dataList.add(new String(reg_berkas_npwp.getBytes()));
            dataList.add(new String(reg_berkas_skt.getBytes()));
            dataList.add(new String(reg_berkas_sppkp.getBytes()));
            dataList.add(new String(reg_berkas_siup.getBytes()));
            String result = polmanAstraRepository.callProcedure("reg_createRegister", dataList.toArray(new String[0]));
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create register", e);
        }
    }*/

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
    public String getListKodePos(Map<String, Object> data) {
        List<String> dataList = new ArrayList<>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            dataList.add(entry.getValue().toString());
        }
        String result = polmanAstraRepository.callProcedure("reg_getListKodePos", dataList.toArray(new String[0]));
        return result;
    }
}
