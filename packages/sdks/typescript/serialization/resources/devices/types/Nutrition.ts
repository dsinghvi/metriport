/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as Metriport from "../../../../api";
import * as core from "../../../../core";

export const Nutrition: core.serialization.ObjectSchema<
    serializers.devices.Nutrition.Raw,
    Metriport.devices.Nutrition
> = core.serialization
    .object({
        summary: core.serialization
            .lazyObject(async () => (await import("../../..")).devices.NutritionFacts)
            .optional(),
        foods: core.serialization
            .list(core.serialization.lazyObject(async () => (await import("../../..")).devices.Food))
            .optional(),
    })
    .extend(core.serialization.lazyObject(async () => (await import("../../..")).devices.MetriportData));

export declare namespace Nutrition {
    interface Raw extends serializers.devices.MetriportData.Raw {
        summary?: serializers.devices.NutritionFacts.Raw | null;
        foods?: serializers.devices.Food.Raw[] | null;
    }
}