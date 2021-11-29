package by.tms.figure.repository;

import by.tms.figure.entity.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ConeRepository {

    private static final Logger logger = LogManager.getLogger();
    private static ConeRepository instance;
    private List<Cone> cones = new ArrayList<>();

    private ConeRepository() {

    }

    public static ConeRepository getInstance() {
        if (instance == null) {
            synchronized (ConeRepository.class) {
                if (instance == null) {
                    logger.info("create a repository");
                    instance = new ConeRepository();
                }
            }
        }
        return instance;
    }

    public boolean add(Cone cone) {
        return cones.add(cone.createCopy());
    }

    public boolean init(List<Cone> coneList) {
        return cones.addAll(coneList);
    }

    public void clear() {
        cones.clear();
    }

    public boolean contains(Cone cone) {
        return cones.contains(cone);
    }

    public Optional<Cone> get(int index) {
        if (index < 0 || index >= cones.size()) {
            return Optional.empty();
        }
        Cone cone = cones.get(index);
        return Optional.of(cone.createCopy());
    }

    public int indexOf(Cone cone) {
        return cones.indexOf(cone);
    }

    public Cone remove(int index) {
        return cones.remove(index);
    }

    public boolean remove(Cone cone) {
        return cones.remove(cone);
    }

    public Cone set(int index, Cone cone) {
        return cones.set(index, cone.createCopy());
    }

    public int size() {
        return cones.size();
    }

    public List<Cone> query(ConeSpecification coneSpecification) {
        return cones.stream()
                .filter(coneSpecification::specify)
                .map(Cone::createCopy)
                .collect(Collectors.toList());
    }

    public List<Cone> sort(Comparator<Cone> comparator) {
        return cones.stream()
                .sorted(comparator)
                .map(Cone::createCopy)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConeRepository{");
        sb.append("cones=").append(cones);
        sb.append('}');
        return sb.toString();
    }
}
