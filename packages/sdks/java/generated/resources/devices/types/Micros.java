/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.devices.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = Micros.Builder.class
)
public final class Micros {
  private final Optional<Integer> biotinMg;

  private final Optional<Integer> caffeineMg;

  private final Optional<Integer> calciumMg;

  private final Optional<Integer> copperMg;

  private final Optional<Integer> folateMg;

  private final Optional<Integer> folicAcidMg;

  private final Optional<Integer> iodineMg;

  private final Optional<Integer> ironMg;

  private final Optional<Integer> magnesiumMg;

  private final Optional<Integer> manganeseMg;

  private final Optional<Integer> phosphorusMg;

  private final Optional<Integer> potassiumMg;

  private final Optional<Integer> seleniumMg;

  private final Optional<Integer> vitaminAMg;

  private final Optional<Integer> vitaminB1Mg;

  private final Optional<Integer> vitaminB2Mg;

  private final Optional<Integer> vitaminB3Mg;

  private final Optional<Integer> vitaminB5Mg;

  private final Optional<Integer> vitaminB6Mg;

  private final Optional<Integer> vitaminB12Mg;

  private final Optional<Integer> vitaminCMg;

  private final Optional<Integer> vitaminDMg;

  private final Optional<Integer> vitaminEMg;

  private final Optional<Integer> vitaminKMg;

  private final Optional<Integer> zincMg;

  private final Map<String, Object> additionalProperties;

  private Micros(Optional<Integer> biotinMg, Optional<Integer> caffeineMg,
      Optional<Integer> calciumMg, Optional<Integer> copperMg, Optional<Integer> folateMg,
      Optional<Integer> folicAcidMg, Optional<Integer> iodineMg, Optional<Integer> ironMg,
      Optional<Integer> magnesiumMg, Optional<Integer> manganeseMg, Optional<Integer> phosphorusMg,
      Optional<Integer> potassiumMg, Optional<Integer> seleniumMg, Optional<Integer> vitaminAMg,
      Optional<Integer> vitaminB1Mg, Optional<Integer> vitaminB2Mg, Optional<Integer> vitaminB3Mg,
      Optional<Integer> vitaminB5Mg, Optional<Integer> vitaminB6Mg, Optional<Integer> vitaminB12Mg,
      Optional<Integer> vitaminCMg, Optional<Integer> vitaminDMg, Optional<Integer> vitaminEMg,
      Optional<Integer> vitaminKMg, Optional<Integer> zincMg,
      Map<String, Object> additionalProperties) {
    this.biotinMg = biotinMg;
    this.caffeineMg = caffeineMg;
    this.calciumMg = calciumMg;
    this.copperMg = copperMg;
    this.folateMg = folateMg;
    this.folicAcidMg = folicAcidMg;
    this.iodineMg = iodineMg;
    this.ironMg = ironMg;
    this.magnesiumMg = magnesiumMg;
    this.manganeseMg = manganeseMg;
    this.phosphorusMg = phosphorusMg;
    this.potassiumMg = potassiumMg;
    this.seleniumMg = seleniumMg;
    this.vitaminAMg = vitaminAMg;
    this.vitaminB1Mg = vitaminB1Mg;
    this.vitaminB2Mg = vitaminB2Mg;
    this.vitaminB3Mg = vitaminB3Mg;
    this.vitaminB5Mg = vitaminB5Mg;
    this.vitaminB6Mg = vitaminB6Mg;
    this.vitaminB12Mg = vitaminB12Mg;
    this.vitaminCMg = vitaminCMg;
    this.vitaminDMg = vitaminDMg;
    this.vitaminEMg = vitaminEMg;
    this.vitaminKMg = vitaminKMg;
    this.zincMg = zincMg;
    this.additionalProperties = additionalProperties;
  }

  @JsonProperty("biotin_mg")
  public Optional<Integer> getBiotinMg() {
    return biotinMg;
  }

  @JsonProperty("caffeine_mg")
  public Optional<Integer> getCaffeineMg() {
    return caffeineMg;
  }

  @JsonProperty("calcium_mg")
  public Optional<Integer> getCalciumMg() {
    return calciumMg;
  }

  @JsonProperty("copper_mg")
  public Optional<Integer> getCopperMg() {
    return copperMg;
  }

  @JsonProperty("folate_mg")
  public Optional<Integer> getFolateMg() {
    return folateMg;
  }

  @JsonProperty("folic_acid_mg")
  public Optional<Integer> getFolicAcidMg() {
    return folicAcidMg;
  }

  @JsonProperty("iodine_mg")
  public Optional<Integer> getIodineMg() {
    return iodineMg;
  }

  @JsonProperty("iron_mg")
  public Optional<Integer> getIronMg() {
    return ironMg;
  }

  @JsonProperty("magnesium_mg")
  public Optional<Integer> getMagnesiumMg() {
    return magnesiumMg;
  }

  @JsonProperty("manganese_mg")
  public Optional<Integer> getManganeseMg() {
    return manganeseMg;
  }

  @JsonProperty("phosphorus_mg")
  public Optional<Integer> getPhosphorusMg() {
    return phosphorusMg;
  }

  @JsonProperty("potassium_mg")
  public Optional<Integer> getPotassiumMg() {
    return potassiumMg;
  }

  @JsonProperty("selenium_mg")
  public Optional<Integer> getSeleniumMg() {
    return seleniumMg;
  }

  @JsonProperty("vitamin_A_mg")
  public Optional<Integer> getVitaminAMg() {
    return vitaminAMg;
  }

  @JsonProperty("vitamin_B1_mg")
  public Optional<Integer> getVitaminB1Mg() {
    return vitaminB1Mg;
  }

  @JsonProperty("vitamin_B2_mg")
  public Optional<Integer> getVitaminB2Mg() {
    return vitaminB2Mg;
  }

  @JsonProperty("vitamin_B3_mg")
  public Optional<Integer> getVitaminB3Mg() {
    return vitaminB3Mg;
  }

  @JsonProperty("vitamin_B5_mg")
  public Optional<Integer> getVitaminB5Mg() {
    return vitaminB5Mg;
  }

  @JsonProperty("vitamin_B6_mg")
  public Optional<Integer> getVitaminB6Mg() {
    return vitaminB6Mg;
  }

  @JsonProperty("vitamin_B12_mg")
  public Optional<Integer> getVitaminB12Mg() {
    return vitaminB12Mg;
  }

  @JsonProperty("vitamin_C_mg")
  public Optional<Integer> getVitaminCMg() {
    return vitaminCMg;
  }

  @JsonProperty("vitamin_D_mg")
  public Optional<Integer> getVitaminDMg() {
    return vitaminDMg;
  }

  @JsonProperty("vitamin_E_mg")
  public Optional<Integer> getVitaminEMg() {
    return vitaminEMg;
  }

  @JsonProperty("vitamin_K_mg")
  public Optional<Integer> getVitaminKMg() {
    return vitaminKMg;
  }

  @JsonProperty("zinc_mg")
  public Optional<Integer> getZincMg() {
    return zincMg;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Micros && equalTo((Micros) other);
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  private boolean equalTo(Micros other) {
    return biotinMg.equals(other.biotinMg) && caffeineMg.equals(other.caffeineMg) && calciumMg.equals(other.calciumMg) && copperMg.equals(other.copperMg) && folateMg.equals(other.folateMg) && folicAcidMg.equals(other.folicAcidMg) && iodineMg.equals(other.iodineMg) && ironMg.equals(other.ironMg) && magnesiumMg.equals(other.magnesiumMg) && manganeseMg.equals(other.manganeseMg) && phosphorusMg.equals(other.phosphorusMg) && potassiumMg.equals(other.potassiumMg) && seleniumMg.equals(other.seleniumMg) && vitaminAMg.equals(other.vitaminAMg) && vitaminB1Mg.equals(other.vitaminB1Mg) && vitaminB2Mg.equals(other.vitaminB2Mg) && vitaminB3Mg.equals(other.vitaminB3Mg) && vitaminB5Mg.equals(other.vitaminB5Mg) && vitaminB6Mg.equals(other.vitaminB6Mg) && vitaminB12Mg.equals(other.vitaminB12Mg) && vitaminCMg.equals(other.vitaminCMg) && vitaminDMg.equals(other.vitaminDMg) && vitaminEMg.equals(other.vitaminEMg) && vitaminKMg.equals(other.vitaminKMg) && zincMg.equals(other.zincMg);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.biotinMg, this.caffeineMg, this.calciumMg, this.copperMg, this.folateMg, this.folicAcidMg, this.iodineMg, this.ironMg, this.magnesiumMg, this.manganeseMg, this.phosphorusMg, this.potassiumMg, this.seleniumMg, this.vitaminAMg, this.vitaminB1Mg, this.vitaminB2Mg, this.vitaminB3Mg, this.vitaminB5Mg, this.vitaminB6Mg, this.vitaminB12Mg, this.vitaminCMg, this.vitaminDMg, this.vitaminEMg, this.vitaminKMg, this.zincMg);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> biotinMg = Optional.empty();

    private Optional<Integer> caffeineMg = Optional.empty();

    private Optional<Integer> calciumMg = Optional.empty();

    private Optional<Integer> copperMg = Optional.empty();

    private Optional<Integer> folateMg = Optional.empty();

    private Optional<Integer> folicAcidMg = Optional.empty();

    private Optional<Integer> iodineMg = Optional.empty();

    private Optional<Integer> ironMg = Optional.empty();

    private Optional<Integer> magnesiumMg = Optional.empty();

    private Optional<Integer> manganeseMg = Optional.empty();

    private Optional<Integer> phosphorusMg = Optional.empty();

    private Optional<Integer> potassiumMg = Optional.empty();

    private Optional<Integer> seleniumMg = Optional.empty();

    private Optional<Integer> vitaminAMg = Optional.empty();

    private Optional<Integer> vitaminB1Mg = Optional.empty();

    private Optional<Integer> vitaminB2Mg = Optional.empty();

    private Optional<Integer> vitaminB3Mg = Optional.empty();

    private Optional<Integer> vitaminB5Mg = Optional.empty();

    private Optional<Integer> vitaminB6Mg = Optional.empty();

    private Optional<Integer> vitaminB12Mg = Optional.empty();

    private Optional<Integer> vitaminCMg = Optional.empty();

    private Optional<Integer> vitaminDMg = Optional.empty();

    private Optional<Integer> vitaminEMg = Optional.empty();

    private Optional<Integer> vitaminKMg = Optional.empty();

    private Optional<Integer> zincMg = Optional.empty();

    @JsonAnySetter
    private Map<String, Object> additionalProperties = new HashMap<>();

    private Builder() {
    }

    public Builder from(Micros other) {
      biotinMg(other.getBiotinMg());
      caffeineMg(other.getCaffeineMg());
      calciumMg(other.getCalciumMg());
      copperMg(other.getCopperMg());
      folateMg(other.getFolateMg());
      folicAcidMg(other.getFolicAcidMg());
      iodineMg(other.getIodineMg());
      ironMg(other.getIronMg());
      magnesiumMg(other.getMagnesiumMg());
      manganeseMg(other.getManganeseMg());
      phosphorusMg(other.getPhosphorusMg());
      potassiumMg(other.getPotassiumMg());
      seleniumMg(other.getSeleniumMg());
      vitaminAMg(other.getVitaminAMg());
      vitaminB1Mg(other.getVitaminB1Mg());
      vitaminB2Mg(other.getVitaminB2Mg());
      vitaminB3Mg(other.getVitaminB3Mg());
      vitaminB5Mg(other.getVitaminB5Mg());
      vitaminB6Mg(other.getVitaminB6Mg());
      vitaminB12Mg(other.getVitaminB12Mg());
      vitaminCMg(other.getVitaminCMg());
      vitaminDMg(other.getVitaminDMg());
      vitaminEMg(other.getVitaminEMg());
      vitaminKMg(other.getVitaminKMg());
      zincMg(other.getZincMg());
      return this;
    }

    @JsonSetter(
        value = "biotin_mg",
        nulls = Nulls.SKIP
    )
    public Builder biotinMg(Optional<Integer> biotinMg) {
      this.biotinMg = biotinMg;
      return this;
    }

    public Builder biotinMg(Integer biotinMg) {
      this.biotinMg = Optional.of(biotinMg);
      return this;
    }

    @JsonSetter(
        value = "caffeine_mg",
        nulls = Nulls.SKIP
    )
    public Builder caffeineMg(Optional<Integer> caffeineMg) {
      this.caffeineMg = caffeineMg;
      return this;
    }

    public Builder caffeineMg(Integer caffeineMg) {
      this.caffeineMg = Optional.of(caffeineMg);
      return this;
    }

    @JsonSetter(
        value = "calcium_mg",
        nulls = Nulls.SKIP
    )
    public Builder calciumMg(Optional<Integer> calciumMg) {
      this.calciumMg = calciumMg;
      return this;
    }

    public Builder calciumMg(Integer calciumMg) {
      this.calciumMg = Optional.of(calciumMg);
      return this;
    }

    @JsonSetter(
        value = "copper_mg",
        nulls = Nulls.SKIP
    )
    public Builder copperMg(Optional<Integer> copperMg) {
      this.copperMg = copperMg;
      return this;
    }

    public Builder copperMg(Integer copperMg) {
      this.copperMg = Optional.of(copperMg);
      return this;
    }

    @JsonSetter(
        value = "folate_mg",
        nulls = Nulls.SKIP
    )
    public Builder folateMg(Optional<Integer> folateMg) {
      this.folateMg = folateMg;
      return this;
    }

    public Builder folateMg(Integer folateMg) {
      this.folateMg = Optional.of(folateMg);
      return this;
    }

    @JsonSetter(
        value = "folic_acid_mg",
        nulls = Nulls.SKIP
    )
    public Builder folicAcidMg(Optional<Integer> folicAcidMg) {
      this.folicAcidMg = folicAcidMg;
      return this;
    }

    public Builder folicAcidMg(Integer folicAcidMg) {
      this.folicAcidMg = Optional.of(folicAcidMg);
      return this;
    }

    @JsonSetter(
        value = "iodine_mg",
        nulls = Nulls.SKIP
    )
    public Builder iodineMg(Optional<Integer> iodineMg) {
      this.iodineMg = iodineMg;
      return this;
    }

    public Builder iodineMg(Integer iodineMg) {
      this.iodineMg = Optional.of(iodineMg);
      return this;
    }

    @JsonSetter(
        value = "iron_mg",
        nulls = Nulls.SKIP
    )
    public Builder ironMg(Optional<Integer> ironMg) {
      this.ironMg = ironMg;
      return this;
    }

    public Builder ironMg(Integer ironMg) {
      this.ironMg = Optional.of(ironMg);
      return this;
    }

    @JsonSetter(
        value = "magnesium_mg",
        nulls = Nulls.SKIP
    )
    public Builder magnesiumMg(Optional<Integer> magnesiumMg) {
      this.magnesiumMg = magnesiumMg;
      return this;
    }

    public Builder magnesiumMg(Integer magnesiumMg) {
      this.magnesiumMg = Optional.of(magnesiumMg);
      return this;
    }

    @JsonSetter(
        value = "manganese_mg",
        nulls = Nulls.SKIP
    )
    public Builder manganeseMg(Optional<Integer> manganeseMg) {
      this.manganeseMg = manganeseMg;
      return this;
    }

    public Builder manganeseMg(Integer manganeseMg) {
      this.manganeseMg = Optional.of(manganeseMg);
      return this;
    }

    @JsonSetter(
        value = "phosphorus_mg",
        nulls = Nulls.SKIP
    )
    public Builder phosphorusMg(Optional<Integer> phosphorusMg) {
      this.phosphorusMg = phosphorusMg;
      return this;
    }

    public Builder phosphorusMg(Integer phosphorusMg) {
      this.phosphorusMg = Optional.of(phosphorusMg);
      return this;
    }

    @JsonSetter(
        value = "potassium_mg",
        nulls = Nulls.SKIP
    )
    public Builder potassiumMg(Optional<Integer> potassiumMg) {
      this.potassiumMg = potassiumMg;
      return this;
    }

    public Builder potassiumMg(Integer potassiumMg) {
      this.potassiumMg = Optional.of(potassiumMg);
      return this;
    }

    @JsonSetter(
        value = "selenium_mg",
        nulls = Nulls.SKIP
    )
    public Builder seleniumMg(Optional<Integer> seleniumMg) {
      this.seleniumMg = seleniumMg;
      return this;
    }

    public Builder seleniumMg(Integer seleniumMg) {
      this.seleniumMg = Optional.of(seleniumMg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_A_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminAMg(Optional<Integer> vitaminAMg) {
      this.vitaminAMg = vitaminAMg;
      return this;
    }

    public Builder vitaminAMg(Integer vitaminAMg) {
      this.vitaminAMg = Optional.of(vitaminAMg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_B1_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminB1Mg(Optional<Integer> vitaminB1Mg) {
      this.vitaminB1Mg = vitaminB1Mg;
      return this;
    }

    public Builder vitaminB1Mg(Integer vitaminB1Mg) {
      this.vitaminB1Mg = Optional.of(vitaminB1Mg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_B2_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminB2Mg(Optional<Integer> vitaminB2Mg) {
      this.vitaminB2Mg = vitaminB2Mg;
      return this;
    }

    public Builder vitaminB2Mg(Integer vitaminB2Mg) {
      this.vitaminB2Mg = Optional.of(vitaminB2Mg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_B3_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminB3Mg(Optional<Integer> vitaminB3Mg) {
      this.vitaminB3Mg = vitaminB3Mg;
      return this;
    }

    public Builder vitaminB3Mg(Integer vitaminB3Mg) {
      this.vitaminB3Mg = Optional.of(vitaminB3Mg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_B5_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminB5Mg(Optional<Integer> vitaminB5Mg) {
      this.vitaminB5Mg = vitaminB5Mg;
      return this;
    }

    public Builder vitaminB5Mg(Integer vitaminB5Mg) {
      this.vitaminB5Mg = Optional.of(vitaminB5Mg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_B6_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminB6Mg(Optional<Integer> vitaminB6Mg) {
      this.vitaminB6Mg = vitaminB6Mg;
      return this;
    }

    public Builder vitaminB6Mg(Integer vitaminB6Mg) {
      this.vitaminB6Mg = Optional.of(vitaminB6Mg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_B12_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminB12Mg(Optional<Integer> vitaminB12Mg) {
      this.vitaminB12Mg = vitaminB12Mg;
      return this;
    }

    public Builder vitaminB12Mg(Integer vitaminB12Mg) {
      this.vitaminB12Mg = Optional.of(vitaminB12Mg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_C_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminCMg(Optional<Integer> vitaminCMg) {
      this.vitaminCMg = vitaminCMg;
      return this;
    }

    public Builder vitaminCMg(Integer vitaminCMg) {
      this.vitaminCMg = Optional.of(vitaminCMg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_D_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminDMg(Optional<Integer> vitaminDMg) {
      this.vitaminDMg = vitaminDMg;
      return this;
    }

    public Builder vitaminDMg(Integer vitaminDMg) {
      this.vitaminDMg = Optional.of(vitaminDMg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_E_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminEMg(Optional<Integer> vitaminEMg) {
      this.vitaminEMg = vitaminEMg;
      return this;
    }

    public Builder vitaminEMg(Integer vitaminEMg) {
      this.vitaminEMg = Optional.of(vitaminEMg);
      return this;
    }

    @JsonSetter(
        value = "vitamin_K_mg",
        nulls = Nulls.SKIP
    )
    public Builder vitaminKMg(Optional<Integer> vitaminKMg) {
      this.vitaminKMg = vitaminKMg;
      return this;
    }

    public Builder vitaminKMg(Integer vitaminKMg) {
      this.vitaminKMg = Optional.of(vitaminKMg);
      return this;
    }

    @JsonSetter(
        value = "zinc_mg",
        nulls = Nulls.SKIP
    )
    public Builder zincMg(Optional<Integer> zincMg) {
      this.zincMg = zincMg;
      return this;
    }

    public Builder zincMg(Integer zincMg) {
      this.zincMg = Optional.of(zincMg);
      return this;
    }

    public Micros build() {
      return new Micros(biotinMg, caffeineMg, calciumMg, copperMg, folateMg, folicAcidMg, iodineMg, ironMg, magnesiumMg, manganeseMg, phosphorusMg, potassiumMg, seleniumMg, vitaminAMg, vitaminB1Mg, vitaminB2Mg, vitaminB3Mg, vitaminB5Mg, vitaminB6Mg, vitaminB12Mg, vitaminCMg, vitaminDMg, vitaminEMg, vitaminKMg, zincMg, additionalProperties);
    }
  }
}