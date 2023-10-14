package vtb.map.map.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vtb.map.map.entities.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "availability")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityEntity extends BaseEntity{
    private Boolean wheelchair_cap;
    private Boolean wheelchair_act;
    private Boolean blind_cap;
    private Boolean blind_act;
    private Boolean nfc_for_bank_cards_cap;
    private Boolean nfc_for_bank_cards_act;
    private Boolean qr_read_cap;
    private Boolean qr_read_act;
    private Boolean supports_usd_cap;
    private Boolean supports_usd_act;
    private Boolean supports_charge_rub_cap;
    private Boolean supports_charge_rub_act;
    private Boolean supports_eur_cap;
    private Boolean supports_eur_act;
    private Boolean supports_rub_cap;
    private Boolean supports_rub_act;
    private Boolean rub_large_bills;
    private Boolean rub_small_bills;
}
