package cl.bennu.controljornadabackend.service;

import cl.bennu.controljornadabackend.mapper.CompanyMapper;
import cl.bennu.controljornadabackend.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {

    private @Autowired CompanyMapper companyMapper;

    public List<Company> getAll() {
        return companyMapper.getAll();
    }

    @Transactional
    public void insert(Company company) {
        companyMapper.insert(company);
    }

    @Transactional
    public void update(Company company) {
        companyMapper.update(company);
    }

    public Company getById(Long companyId) {
        return companyMapper.get(companyId);
    }

    public void delete(Long companyId) {
        companyMapper.delete(companyId);
    }

}
