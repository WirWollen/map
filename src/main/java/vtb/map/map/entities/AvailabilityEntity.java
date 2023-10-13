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
    @OneToOne
    @JoinColumn(name = "wheelchair_entity_id")
    private PartEntity wheelchairEntity;
    @OneToOne
    @JoinColumn(name = "C_entity_id")
    private PartEntity blindEntity;
    @OneToOne
    @JoinColumn(name = "nfc_for_bank_cards_entity_id")
    private PartEntity nfc_for_bank_cardsEntity;
    @OneToOne
    @JoinColumn(name = "qr_read_entity_id")
    private PartEntity qr_readEntity;
    @OneToOne
    @JoinColumn(name = "supports_usd_entity_id")
    private PartEntity supports_usdEntity;
    @OneToOne
    @JoinColumn(name = "supports_charge_rub_entity_id")
    private PartEntity supports_charge_rubEntity;
    @OneToOne
    @JoinColumn(name = "supports_eur_entity_id")
    private PartEntity supports_eurEntity;
    @OneToOne
    @JoinColumn(name = "supports_rub_entity_id")
    private PartEntity supports_rubEntity;
}
