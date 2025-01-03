package com.company.organisationbceaorefonte.view.structure;

import com.company.organisationbceaorefonte.entity.Structure;
import com.company.organisationbceaorefonte.entity.TypeStructure;
import com.company.organisationbceaorefonte.service.AgentService;
import com.company.organisationbceaorefonte.view.main.MainView;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.Route;
import io.jmix.core.DataManager;
import io.jmix.flowui.component.grid.TreeDataGrid;
import io.jmix.flowui.data.grid.ContainerTreeDataGridItems;
import io.jmix.flowui.data.grid.TreeDataGridItems;
import io.jmix.flowui.model.CollectionLoader;
import io.jmix.flowui.view.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


@Route(value = "structures", layout = MainView.class)
@ViewController(id = "Structure.list")
@ViewDescriptor(path = "structure-list-view.xml")
@LookupComponent("structuresDataGrid")
@DialogMode(width = "64em")
public class StructureListView extends StandardListView<Structure> {
    private List<String> codes = new ArrayList<>();
    private boolean autreComosant;
    @ViewComponent
    private CollectionLoader<Structure> structuresDl;
    @ViewComponent
    private TreeDataGrid<Structure> structuresTreeDataGrid;
    @ViewComponent("tabsheetId.arborescenceId")
    private Tab tabsheetIdArborescenceId;
    @Autowired
    private AgentService agentService;

    public void setTypeStructure(List<String> codes) {
        this.codes = codes;
    }

    public void setAutreComosant(boolean autreComosant) {this.autreComosant = autreComosant;}

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        structuresDl.setParameter("size", autreComosant ? 1 : 0);
        structuresDl.setParameter("codes", codes!=null ? codes : new ArrayList<>());
        tabsheetIdArborescenceId.setVisible(!autreComosant);

        structuresDl.load();

    }

    public CollectionLoader<Structure> getStructuresDl() {
        return structuresDl;
    }
}