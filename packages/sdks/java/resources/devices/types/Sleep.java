/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.devices.types;

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
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = Sleep.Builder.class
)
public final class Sleep implements IMetriportData {
  private final Metadata metadata;

  private final Optional<String> startTime;

  private final Optional<String> endTime;

  private final Optional<SleepDurations> durations;

  private final Optional<SleepBiometrics> biometrics;

  private final Optional<Integer> wakeupFrequency;

  private Sleep(Metadata metadata, Optional<String> startTime, Optional<String> endTime,
      Optional<SleepDurations> durations, Optional<SleepBiometrics> biometrics,
      Optional<Integer> wakeupFrequency) {
    this.metadata = metadata;
    this.startTime = startTime;
    this.endTime = endTime;
    this.durations = durations;
    this.biometrics = biometrics;
    this.wakeupFrequency = wakeupFrequency;
  }

  @JsonProperty("metadata")
  @Override
  public Metadata getMetadata() {
    return metadata;
  }

  @JsonProperty("start_time")
  public Optional<String> getStartTime() {
    return startTime;
  }

  @JsonProperty("end_time")
  public Optional<String> getEndTime() {
    return endTime;
  }

  @JsonProperty("durations")
  public Optional<SleepDurations> getDurations() {
    return durations;
  }

  @JsonProperty("biometrics")
  public Optional<SleepBiometrics> getBiometrics() {
    return biometrics;
  }

  @JsonProperty("wakeup_frequency")
  public Optional<Integer> getWakeupFrequency() {
    return wakeupFrequency;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Sleep && equalTo((Sleep) other);
  }

  private boolean equalTo(Sleep other) {
    return metadata.equals(other.metadata) && startTime.equals(other.startTime) && endTime.equals(other.endTime) && durations.equals(other.durations) && biometrics.equals(other.biometrics) && wakeupFrequency.equals(other.wakeupFrequency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.metadata, this.startTime, this.endTime, this.durations, this.biometrics, this.wakeupFrequency);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static MetadataStage builder() {
    return new Builder();
  }

  public interface MetadataStage {
    _FinalStage metadata(Metadata metadata);

    Builder from(Sleep other);
  }

  public interface _FinalStage {
    Sleep build();

    _FinalStage startTime(Optional<String> startTime);

    _FinalStage startTime(String startTime);

    _FinalStage endTime(Optional<String> endTime);

    _FinalStage endTime(String endTime);

    _FinalStage durations(Optional<SleepDurations> durations);

    _FinalStage durations(SleepDurations durations);

    _FinalStage biometrics(Optional<SleepBiometrics> biometrics);

    _FinalStage biometrics(SleepBiometrics biometrics);

    _FinalStage wakeupFrequency(Optional<Integer> wakeupFrequency);

    _FinalStage wakeupFrequency(Integer wakeupFrequency);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements MetadataStage, _FinalStage {
    private Metadata metadata;

    private Optional<Integer> wakeupFrequency = Optional.empty();

    private Optional<SleepBiometrics> biometrics = Optional.empty();

    private Optional<SleepDurations> durations = Optional.empty();

    private Optional<String> endTime = Optional.empty();

    private Optional<String> startTime = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Sleep other) {
      metadata(other.getMetadata());
      startTime(other.getStartTime());
      endTime(other.getEndTime());
      durations(other.getDurations());
      biometrics(other.getBiometrics());
      wakeupFrequency(other.getWakeupFrequency());
      return this;
    }

    @Override
    @JsonSetter("metadata")
    public _FinalStage metadata(Metadata metadata) {
      this.metadata = metadata;
      return this;
    }

    @Override
    public _FinalStage wakeupFrequency(Integer wakeupFrequency) {
      this.wakeupFrequency = Optional.of(wakeupFrequency);
      return this;
    }

    @Override
    @JsonSetter(
        value = "wakeup_frequency",
        nulls = Nulls.SKIP
    )
    public _FinalStage wakeupFrequency(Optional<Integer> wakeupFrequency) {
      this.wakeupFrequency = wakeupFrequency;
      return this;
    }

    @Override
    public _FinalStage biometrics(SleepBiometrics biometrics) {
      this.biometrics = Optional.of(biometrics);
      return this;
    }

    @Override
    @JsonSetter(
        value = "biometrics",
        nulls = Nulls.SKIP
    )
    public _FinalStage biometrics(Optional<SleepBiometrics> biometrics) {
      this.biometrics = biometrics;
      return this;
    }

    @Override
    public _FinalStage durations(SleepDurations durations) {
      this.durations = Optional.of(durations);
      return this;
    }

    @Override
    @JsonSetter(
        value = "durations",
        nulls = Nulls.SKIP
    )
    public _FinalStage durations(Optional<SleepDurations> durations) {
      this.durations = durations;
      return this;
    }

    @Override
    public _FinalStage endTime(String endTime) {
      this.endTime = Optional.of(endTime);
      return this;
    }

    @Override
    @JsonSetter(
        value = "end_time",
        nulls = Nulls.SKIP
    )
    public _FinalStage endTime(Optional<String> endTime) {
      this.endTime = endTime;
      return this;
    }

    @Override
    public _FinalStage startTime(String startTime) {
      this.startTime = Optional.of(startTime);
      return this;
    }

    @Override
    @JsonSetter(
        value = "start_time",
        nulls = Nulls.SKIP
    )
    public _FinalStage startTime(Optional<String> startTime) {
      this.startTime = startTime;
      return this;
    }

    @Override
    public Sleep build() {
      return new Sleep(metadata, startTime, endTime, durations, biometrics, wakeupFrequency);
    }
  }
}