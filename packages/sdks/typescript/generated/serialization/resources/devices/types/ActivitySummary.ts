/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as Metriport from "../../../../api";
import * as core from "../../../../core";

export const ActivitySummary: core.serialization.ObjectSchema<
    serializers.devices.ActivitySummary.Raw,
    Metriport.devices.ActivitySummary
> = core.serialization.object({
    durations: core.serialization
        .lazyObject(async () => (await import("../../..")).devices.ActivityDurations)
        .optional(),
    energyExpenditure: core.serialization.property(
        "energy_expenditure",
        core.serialization.lazyObject(async () => (await import("../../..")).devices.EnergyExpenditure).optional()
    ),
    biometrics: core.serialization.lazyObject(async () => (await import("../../..")).devices.Biometrics).optional(),
});

export declare namespace ActivitySummary {
    interface Raw {
        durations?: serializers.devices.ActivityDurations.Raw | null;
        energy_expenditure?: serializers.devices.EnergyExpenditure.Raw | null;
        biometrics?: serializers.devices.Biometrics.Raw | null;
    }
}