/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as Metriport from "../../../../api";
import * as core from "../../../../core";

export const NutritionFacts: core.serialization.ObjectSchema<
    serializers.devices.NutritionFacts.Raw,
    Metriport.devices.NutritionFacts
> = core.serialization.object({
    macros: core.serialization.lazyObject(async () => (await import("../../..")).devices.Macros).optional(),
    micros: core.serialization.lazyObject(async () => (await import("../../..")).devices.Micros).optional(),
    aminos: core.serialization.lazyObject(async () => (await import("../../..")).devices.Aminos).optional(),
});

export declare namespace NutritionFacts {
    interface Raw {
        macros?: serializers.devices.Macros.Raw | null;
        micros?: serializers.devices.Micros.Raw | null;
        aminos?: serializers.devices.Aminos.Raw | null;
    }
}