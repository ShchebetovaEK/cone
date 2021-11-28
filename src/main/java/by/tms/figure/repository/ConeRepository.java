package by.tms.figure.repository;

import by.tms.figure.entity.Cone;
import by.tms.figure.entity.ConeWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository {

    private static final Logger logger = LogManager.getLogger();
    private static ConeRepository instance;
    private final ConeRepository coneRepository = ConeRepository.getInstance();
    private List<Cone> cones = new ArrayList<>();

    private ConeRepository() {
        cones = new ArrayList<>();
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

    public void ConeRepository(List<Cone> cones) {
        for (Cone cone: cones) {
            coneRepository.add(cone);
        }
        logger.info("Repository filled successfully");
    }

    public boolean add(Cone cone){
        return cones.add(cone);
    }

    public boolean addAll(List<Cone> coneList){
        return cones.addAll(coneList);
    }

    public void clear(){
        cones.clear();
    }

    public boolean contains(Cone cone){
        return cones.contains(cone);
    }

    public Cone get(int index){
        return  cones.get(index);
    }

    public int indexOf (Cone cone){
        return cones.indexOf(cone);
    }

    public Cone remove (int index){
        return cones.remove(index);
    }

    public boolean remove(Cone cone){
        return cones.remove(cone);
    }

    public Cone set(int index,Cone cone){
        return cones.set(index,cone);
    }

    public int size(){
        return cones.size();
    }

    public List<Cone> query (ConeSpecification coneSpecification){
        return cones.stream()
                .filter(coneSpecification::specify)
                .collect(Collectors.toList());
    }

    public  List<Cone> sort(Comparator<Cone> comparator){
        return cones.stream().sorted(comparator).collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        return cones.equals(o);
    }

    @Override
    public int hashCode() {
        return cones.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ConeRepository{");
        sb.append("cones=").append(cones);
        sb.append('}');
        return sb.toString();
    }
}
