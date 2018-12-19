package it.akademija.service;

import it.akademija.entity.Book;
import it.akademija.entity.Institution;
import it.akademija.enums.InstitutionCategory;
import it.akademija.model.RequestInstitution;
import it.akademija.repository.InstitutionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstitutionService {

    private static final Logger LOG = LoggerFactory.getLogger(InstitutionService.class);

    @Autowired
    private InstitutionRepository institutionRepository;

    @Transactional
    public List<Institution> getAll(){
        return institutionRepository.findAll().stream().collect(Collectors.toList());
    }

    @Transactional
    public void createInstitution(RequestInstitution requestInstitution){
        Institution institution = new Institution(
                requestInstitution.getTitle() + (Math.floor(Math.random() * 10)+1),
                requestInstitution.getTitle(),
                requestInstitution.getCity(),
                requestInstitution.getImage(),
                requestInstitution.getCategory(),
                requestInstitution.getType(),
                requestInstitution.getSubType()
        );
        institutionRepository.save(institution);
    }

    @Transactional
    public List<RequestInstitution> getAllInstitutions(){
        List<RequestInstitution> requestInstitutions = institutionRepository.findAll().stream()
                .map(insitution -> new RequestInstitution(
                        insitution.getTitle(), insitution.getCity(), insitution.getImage(), insitution.getCategory(),
                        insitution.getType(), insitution.getSubType()))
                .collect(Collectors.toList());
        return requestInstitutions;
    }

    @Transactional
    public List<RequestInstitution> getInstitutionsByCategory() {

        List<RequestInstitution>  requestInstitutions = institutionRepository.findAll(Sort.by("category"))
                .stream()
                .map(insitution -> new RequestInstitution(
                        insitution.getTitle(), insitution.getCity(), insitution.getImage(), insitution.getCategory(),
                       insitution.getType(), insitution.getSubType()))
                .collect(Collectors.toList());
        return  requestInstitutions;
    }

    @Transactional
    public List<RequestInstitution> getInstitutionsByCategoryAndType() {

        List<RequestInstitution>  requestInstitutions = institutionRepository.findAll(Sort.by("category").and(Sort.by("type")))
                .stream()
                .map(insitution -> new RequestInstitution(
                        insitution.getTitle(), insitution.getCity(), insitution.getImage(), insitution.getCategory(),
                        insitution.getType(), insitution.getSubType()))
                .collect(Collectors.toList());
        return  requestInstitutions;
    }

    public RequestInstitution getInstitutionByTitle(String title){
        Institution institution = institutionRepository.findByTitle(title);

        RequestInstitution requestInstitution = new RequestInstitution(
                institution.getTitle(),
                institution.getCity(),
                institution.getImage(),
                institution.getCategory(),
                institution.getType(),
                institution.getSubType()
//                institution.getBookSet()
        );
        return requestInstitution;
    }

    @Transactional
    public void updateInstition(RequestInstitution requestInstitution, String title){
        Institution institution = institutionRepository.findByTitle(title);

                institution.setTitle(requestInstitution.getTitle());
                institution.setCity(requestInstitution.getCity());
                institution.setImage(requestInstitution.getCity());
                institution.setCategory(requestInstitution.getCategory());
                institution.setType(requestInstitution.getType());
                institution.setSubType(requestInstitution.getSubType());
                institution.setBookSet(requestInstitution.getBookSet());
    }

    @Transactional
    public void deleteInstitution(String title){
        Institution institution = institutionRepository.findByTitle(title);

        for (Book book : institution.getBookSet()) { // removing book from inverse side institution assocition and deleting institution
            book.getInstitutions().remove(institution);
        }
        institutionRepository.delete(institution);

       // arba
//        Institution institution = institutionRepository.findByTitle(title);
//        institution.getBookSet().removeAll(institution.getBookSet());
//        institutionRepository.delete(institution);
    }

//    @InitBinder
//    public void initBinder(final WebDataBinder webdataBinder) {
//        webdataBinder.registerCustomEditor(InstitutionCategory.class, new InstitutionCategoryConverter());
//    }

}
