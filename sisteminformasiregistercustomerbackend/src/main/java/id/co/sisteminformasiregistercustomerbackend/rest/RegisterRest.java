package id.co.sisteminformasiregistercustomerbackend.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.sisteminformasiregistercustomerbackend.config.EncodeData;
import id.co.sisteminformasiregistercustomerbackend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/RegisterCustomer")
public class RegisterRest {
    @Autowired
    private RegisterService mRegisterService;

    @Autowired
    private EncodeData encodeData;

    @PostMapping("/GetDataRegister")
    public ResponseEntity<String> getDataRegister(@RequestBody Map<String, Object> data) {
        System.out.println(data);
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.getDataRegister(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get data", e);
        }
    }

    @PostMapping("/GetDataRegisterById")
    public ResponseEntity<String> getDataRegisterById(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.getDataRegisterById(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get data", e);
        }
    }

    @PostMapping("/CreateRegister")
    public ResponseEntity<String> createRegister(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.createRegister(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            System.out.println(e.toString());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create data", e);
        }
    }

    /*@PostMapping("/CreateRegister")
    public ResponseEntity<String> createRegister(
            @RequestParam("data") String data,
            @RequestParam("reg_berkas_nib") MultipartFile reg_berkas_nib,
            @RequestParam("reg_berkas_npwp") MultipartFile reg_berkas_npwp,
            @RequestParam("reg_berkas_skt") MultipartFile reg_berkas_skt,
            @RequestParam("reg_berkas_sppkp") MultipartFile reg_berkas_sppkp,
            @RequestParam("reg_berkas_siup") MultipartFile reg_berkas_siup) {
        try {
            Map<String, Object> decodedData = new ObjectMapper().readValue(data, Map.class);
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(decodedData);
            String result = mRegisterService.createRegister(
                    encodedData, reg_berkas_nib, reg_berkas_npwp, reg_berkas_skt,
                    reg_berkas_sppkp, reg_berkas_siup);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create data", e);
        }
    }*/

    @PostMapping("/DetailRegister")
    public ResponseEntity<String> detailRegister(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.detailRegister(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get data", e);
        }
    }

//    @PostMapping("/EditProses")
//    public ResponseEntity<String> editProses(@RequestBody Map<String, Object> data) {
//        try {
//            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
//            String result = mRegisterService.ed(encodedData);
//            return ResponseEntity.ok().body(result);
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to edit data", e);
//        }
//    }

    @PostMapping("/SetStatusRegister")
    public ResponseEntity<String> setStatusRegister(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.setStatusRegister(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to set status", e);
        }
    }

    @PostMapping("/GetListKodePos")
    public ResponseEntity<String> getListKodePos(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.getListKodePos(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get list", e);
        }
    }

}
