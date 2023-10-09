package vtb.map.map.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vtb.map.map.converters.MarketingConverter;
import vtb.map.map.dtos.MarketingDto;
import vtb.map.map.repo.MarketingRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MarketingService {
    private final MarketingRepo marketingRepo;

    public List<MarketingDto> showAllMarketing() {
        return marketingRepo.findAll().stream().map(MarketingConverter::toDto).collect(Collectors.toList());
    }

    public MarketingDto showMarketingDto(long id) {
        return MarketingConverter.toDto(marketingRepo.findById(id).get());
    }

    public boolean addMarketingList(List<MarketingDto> dtoList) {
        marketingRepo.saveAll(dtoList.stream().map(MarketingConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateMarketing(MarketingDto dto) {
        if (marketingRepo.existsById(dto.getId())) {
            marketingRepo.save(MarketingConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteMarketingById(long id) {
        marketingRepo.deleteById(id);
        return true;
    }
}
