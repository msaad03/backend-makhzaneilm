package io.magazine.makhzaneilm.service.impl;

import io.magazine.makhzaneilm.entity.File;
import io.magazine.makhzaneilm.repository.FileRepository;
import io.magazine.makhzaneilm.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public File store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        File fileDB = new File(fileName, file.getContentType(), file.getBytes());
        return fileRepository.save(fileDB);
    }
    @Override
    public File getFile(String id) {
        return fileRepository.findById(id).get();
    }

    @Override
    public Stream<File> getAllFiles() {
        return fileRepository.findAll().stream();
    }
}
