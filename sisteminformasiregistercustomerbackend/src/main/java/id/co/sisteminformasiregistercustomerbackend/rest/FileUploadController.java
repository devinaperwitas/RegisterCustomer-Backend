package id.co.sisteminformasiregistercustomerbackend.rest;

import id.co.sisteminformasiregistercustomerbackend.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
@CrossOrigin
@RestController
@RequestMapping("/api/Upload")
public class FileUploadController {
    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/UploadFile")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String filePath = fileUploadService.storeFile(file);
            String fileName = StringUtils.getFilename(filePath); // Mengambil nama file dari path
            return ResponseEntity.ok().body("{\"Hasil\": \"" + file.getOriginalFilename() + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }
    }
}

