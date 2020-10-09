package pl.coderslab.project.dbImage;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Transactional
public class DbImageServiceImpl implements DbImageService {

    DbImageRepository dbImageRepository;

    @Override
    public List<DbImage> getAllByContentTypeStartsWith(String mediaType) {
        return dbImageRepository.findAllByContentTypeStartsWith(mediaType);
    }

    @Override
    public DbImage getWithDataById(Long id) {
        return dbImageRepository.findWithDataById(id);
    }

    @Override
    public void saveFile(DbImage dbFile) {
dbImageRepository.save(dbFile);
    }

    @Override
    public List<DbImage> getAllDbFileWithProductRelations() {
        return dbImageRepository.findAllDbFileWithProductRelations();
    }

    @Override
    public DbImage getById(Long id) {
        return dbImageRepository.getOne(id);
    }

    @Override
    public void deleteDbImageById(Long id) {
dbImageRepository.deleteById(id);
    }

    @Override
    public void deleteAllDbImages() {
dbImageRepository.deleteAll();
    }


}
