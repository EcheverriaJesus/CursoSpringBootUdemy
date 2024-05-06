package com.possystem.possystem.services.ServiceImpls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.possystem.possystem.dto.DebtDTO;
import com.possystem.possystem.entities.Debt;
import com.possystem.possystem.repositories.DebtRepository;
import com.possystem.possystem.services.DebtService;

@Service
public class DebtServiceImpl implements DebtService {

    @Autowired
    private DebtRepository debtRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DebtDTO> findAll() {
        List<Debt> debts = debtRepository.findAll();
        return debts.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<DebtDTO> findByName(String name) {
        Optional<Debt> debtOptional = debtRepository.findByName(name);
        return debtOptional.map(this::mapToDTO);
    }

    @Override
    @Transactional
    public DebtDTO save(DebtDTO debt) {
        Debt debtEntity = mapToEntity(debt);
        debtEntity = debtRepository.save(debtEntity);
        return mapToDTO(debtEntity);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        debtRepository.deleteByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DebtDTO> findAll(Pageable pageable) {
        return debtRepository.findAll(pageable).map(this::mapToDTO);

    }

    private DebtDTO mapToDTO(Debt debt) {
        DebtDTO debtDTO = new DebtDTO();
        debtDTO.setName(debt.getName());
        debtDTO.setDescription(debt.getDescription());
        debtDTO.setLeavemoney(debt.getLeavemoney());
        debtDTO.setSubtract(debt.getSubtract());
        debtDTO.setTotal(debt.getTotal());
        return debtDTO;
    }

    private Debt mapToEntity(DebtDTO debtDTO) {
        Debt debt = new Debt();
        debt.setName(debtDTO.getName());
        debt.setDescription(debtDTO.getDescription());
        debt.setLeavemoney(debtDTO.getLeavemoney());
        debt.setSubtract(debtDTO.getSubtract());
        debt.setTotal(debtDTO.getTotal());
        return debt;
    }

}
