package vtb.map.map.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityDto {
    private Long id;
    private PartDto wheelchair;
    private PartDto blind;
    private PartDto nfc_for_bank_cards;
    private PartDto qr_read;
    private PartDto supports_usd;
    private PartDto supports_charge_rub;
    private PartDto supports_eur;
    private PartDto supports_rub;

}
