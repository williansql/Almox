package fofaps.apps.almox.items.item;

import fofaps.apps.almox.utils.exceptions.BadRequestExceptions;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemsService {

    private final ItemsRepository itemsRepository;
    public Items create(Items items) throws BadRequestExceptions {
        if (itemsRepository.findByNameIgnoreCase(items.getName()).isPresent())
            throw new BadRequestExceptions("já existe um item com esse nome");
        return itemsRepository.save(items);
    }

    public Items findAll(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageNumber());
    }
}
