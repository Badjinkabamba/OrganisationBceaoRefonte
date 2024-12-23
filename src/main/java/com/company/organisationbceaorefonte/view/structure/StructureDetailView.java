package com.company.organisationbceaorefonte.view.structure;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.service.StructureService;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.DialogWindows;
import io.jmix.flowui.component.valuepicker.EntityPicker;
import io.jmix.flowui.kit.action.ActionPerformedEvent;
import io.jmix.flowui.model.CollectionContainer;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.model.DataLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "structures/:id", layout = MainView.class)
@ViewController(id = "Structure.detail")
@ViewDescriptor(path = "structure-detail-view.xml")
@EditedEntityContainer("structureDc")
public class StructureDetailView extends StandardDetailView<Structure> {
    @Autowired
    private DataManager dataManager;
    @ViewComponent
    private EntityPicker<Structure> structureParentField;

     List<String> listeCode = new ArrayList<>();
/* @ViewComponent
    private CollectionContainer<Structure> structuresParentDc;*/
@Autowired
private DialogWindows dialogWindows;

    private void openViewWithParams(List<String> codes) {
        dialogWindows.lookup(this, Structure.class)
                .withViewClass(StructureListView.class)
                .withSelectHandler(structure -> {
                  getEditedEntity().setStructureParent(structure.stream().findFirst().get());
                })
//                .withViewConfigurer(view -> {
//                    // Assuming the lookup view has a data loader with the ID "structuresDl"
//                    view.setTypeStructure("TYPE_STRUCT_GOUVERNEMENT");
//                })
                .withAfterOpenListener(afterOpenEvent -> {
                    final StructureListView view = afterOpenEvent.getView();
                    DataLoader dataLoader = view.getStructuresDl();
                    if (dataLoader != null) {

                        dataLoader.setParameter("code",codes);
                        dataLoader.load();
                    }
                })
                .open();
    }
    @Subscribe("typeStructureField")
    public void onTypeStructureFieldComponentValueChange(final AbstractField.ComponentValueChangeEvent<EntityPicker<TypeStructure>, TypeStructure> event) {
        Structure structure = getEditedEntity();
        TypeStructure type = structure.getTypeStructure();
        List<Structure> listStructue = dataManager.load( Structure.class)
                    .query("select  e from Structure e where e.structureParent is null").list();
         listeCode = type.getTypeStructureParent().stream().map(TypeStructure::getCode).toList();

    }

    @Subscribe("structureParentField.entityLookup")
    public void onStructureParentFieldEntityLookup(final ActionPerformedEvent event) {
        openViewWithParams(listeCode);
    }



}