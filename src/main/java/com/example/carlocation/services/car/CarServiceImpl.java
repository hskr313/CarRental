package com.example.carlocation.services.car;

import com.example.carlocation.models.Period;
import com.example.carlocation.models.entities.Car;
import com.example.carlocation.models.entities.Model;
import com.example.carlocation.models.entities.Option;
import com.example.carlocation.repositories.CarRepository;
import com.example.carlocation.repositories.ModelRepository;
import com.example.carlocation.repositories.OptionRepository;
import com.example.carlocation.repositories.ReservationRepository;
import com.example.carlocation.services.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl extends CrudServiceImpl<CarRepository, Car, Long>
        implements CarService{

    private final ReservationRepository  reservationRepository;
    private final OptionRepository optionRepository;

    private final ModelRepository modelRepository;

    public CarServiceImpl(CarRepository repository, ReservationRepository reservationRepository, OptionRepository optionRepository, ModelRepository modelRepository) {
        super(repository);
        this.reservationRepository = reservationRepository;
        this.optionRepository = optionRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public boolean isAvailable(Car car, LocalDate startAt, LocalDate endAt) {
        return reservationRepository.findAllByCar(car).stream().noneMatch(it -> {
            Period bookPeriod = new Period(it.getRemoval(), it.getRestitution());
            Period tryToBookPeriod = new Period(startAt, endAt);
            return tryToBookPeriod.isOverlap(bookPeriod);
        });
    }

    @Override
    public List<Car> getCarsByAvailable(LocalDate startAt, LocalDate endAt) {
        return this.repository.findAll().stream()
                .filter(car -> this.isAvailable(car,startAt,endAt))
                .toList();
    }

    @Override
    public double getIndicativePriceByPricingAndFormula(Long id, Long pcId, Long fId) {
        return this.repository.getIndicativePriceByPricingAndFormula(id,pcId,fId);
    }

    @Override
    public Car save(Car car) {
        Model.ModelId modelId = car.getModel().getId();

        List<String> optionNames = car.getModel().getOptions().stream().map(Option::getOptionName).toList();
        List<Option> options = this.optionRepository.findAllByOptionNameContains(optionNames);
        if (options.size() != car.getModel().getOptions().size()) {
            //REMOVE EXISTING FROM car.getModel.getOptions

            options.addAll(this.optionRepository.saveAll(car.getModel().getOptions()));
        }

        Optional<Model> optModel = this.modelRepository.findById(modelId);
        Model model = null;
        if (optModel.isEmpty()) {
            model = optModel.orElse(Model.builder()
                    .id(modelId)
                    .options(options)
                    .pricingClass(car.getModel().getPricingClass())
                    .build()
            );
        } else {
            model = optModel.get();
        }

        car.setModel(model);


        return this.repository.save(car);
    }

}
