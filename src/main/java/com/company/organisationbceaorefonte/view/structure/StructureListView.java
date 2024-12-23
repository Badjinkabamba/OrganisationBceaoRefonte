package com.company.organisationbceaorefonte.view.structure;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.router.Route;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;

import java.util.ArrayList;
import java.util.List;


@Route(value = "structures", layout = MainView.class)
@ViewController(id = "Structure.list")
@ViewDescriptor(path = "structure-list-view.xml")
@LookupComponent("structuresDataGrid")
@DialogMode(width = "64em")
public class StructureListView extends StandardListView<Structure> {
    private List<String> codes = new ArrayList<>();
    private String code;
    @ViewComponent
    private CollectionLoader<Structure> structuresDl;


    public void setTypeStructure(List<String> codes) {
        this.codes = codes;
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        System.out.println("Txxype; " + codes);
        //structuresDl.setParameter("code", codes);
        if (codes == null || codes.isEmpty()) {
            structuresDl.setParameter("size", codes.size());
            structuresDl.setParameter("codes", codes);

        } else {
            structuresDl.setParameter("size", codes.size());
            structuresDl.setParameter("codes", codes);

        }
        structuresDl.load();

    }

    public CollectionLoader<Structure> getStructuresDl() {
        return structuresDl;
    }
}