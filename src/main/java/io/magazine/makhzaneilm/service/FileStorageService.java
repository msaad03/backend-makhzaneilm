package io.magazine.makhzaneilm.service;

import io.magazine.makhzaneilm.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface FileStorageService {
    File store(MultipartFile file) throws IOException;

    File getFile(String id);

    Stream<File> getAllFiles();
}
