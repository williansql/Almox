package fofaps.apps.almox.items.item.utils;

import fofaps.apps.almox.items.item.Items;
import fofaps.apps.almox.items.item.dtos.ItemsDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemsUtils {

    private final ModelMapper modelMapper;

    public Items transformDTOToEntity(ItemsDTO itemsDTO) {
        return modelMapper.map(itemsDTO, Items.class);
    }

    public ItemsDTO TransformItemsToDTO(Items items) {
        return modelMapper.map(items, ItemsDTO.class);
    }


}
