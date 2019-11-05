package com.msf.msfmng.service.sys;

import com.eigpay.idf.entity.Institution;
import com.eigpay.idf.repository.InstitutionRepository;
import com.eigpay.idf.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-30
 */
@Service
public class InstitutionServiceImpl
        extends BaseServiceImpl<InstitutionRepository, Institution> implements InstitutionService {

    private static List<Institution> rearrangeList = new ArrayList<>();

    @Override
    public List<Institution> list(Institution query) {

        List<Institution> list = repository.findAll();

        Institution rootNode = new Institution();
        rootNode.setId(0L);
        rearrangeList.clear();

        return depthFirstSearch(list, rootNode);
    }

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        super(institutionRepository);
        //this.repository = institutionRepository;
    }


    private List<Institution> depthFirstSearch(List<Institution> nodes, Institution node) {

        for (Institution n : allChildNode(nodes, node.getId())) {
            rearrangeList.add(n);
            depthFirstSearch(nodes, n);
        }

        return rearrangeList;
    }


    private List<Institution> allChildNode(List<Institution> nodes, Long parentId) {
        List<Institution> firstLevelNodes = new ArrayList<>();
        for (Institution o : nodes) {
            if (o.getPid().equals(parentId)) {
                firstLevelNodes.add(o);
            }
        }

        firstLevelNodes.sort(Comparator.comparing(Institution::getSort));

        return firstLevelNodes;
    }
}
