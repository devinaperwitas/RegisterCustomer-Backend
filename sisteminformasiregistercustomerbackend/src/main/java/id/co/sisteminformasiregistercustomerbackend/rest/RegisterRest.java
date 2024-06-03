package id.co.sisteminformasiregistercustomerbackend.rest;

import id.co.sisteminformasiregistercustomerbackend.config.EncodeData;
import id.co.sisteminformasiregistercustomerbackend.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        System.out.println(data);
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.createRegister(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create data", e);
        }
    }

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

    @PostMapping("/GetListRegister")
    public ResponseEntity<String> getListRegister(@RequestBody Map<String, Object> data) {
        try {
            Map<String, Object> encodedData = encodeData.htmlEncodeObject(data);
            String result = mRegisterService.getListRegister(encodedData);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to get list", e);
        }
    }
}
