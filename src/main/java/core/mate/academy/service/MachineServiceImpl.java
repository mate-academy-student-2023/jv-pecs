package core.mate.academy.service;

import core.mate.academy.model.Bulldozer;
import core.mate.academy.model.Excavator;
import core.mate.academy.model.Machine;
import core.mate.academy.model.Truck;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Your implementation of MachineService.
 */
public class MachineServiceImpl implements MachineService<Machine> {
    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        List<? extends Machine> machines = Collections.emptyList();
        if (type == Bulldozer.class) {
            machines = new BulldozerProducer().get();
        } else if (type == Excavator.class) {
            machines = new ExcavatorProducer().get();
        } else if (type == Truck.class) {
            machines = new TruckProducer().get();
        }
        return new ArrayList<>(machines);
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (int i = 0; i < machines.size(); i++) {
            Machine machine = machines.get(i);
            machine.doWork();
        }
    }
}
