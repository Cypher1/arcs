/**
 * @license
 * Copyright (c) 2017 Google Inc. All rights reserved.
 * This code may only be used under the BSD style license found at
 * http://polymer.github.io/LICENSE.txt
 * Code distributed by Google as part of this project is also
 * subject to an additional IP rights grant found at
 * http://polymer.github.io/PATENTS.txt
 */

import {assert} from '../../platform/chai-web.js';
import {Arc} from '../arc.js';
import {ArcId} from '../id.js';
import {Loader} from '../../platform/loader.js';
import {Manifest} from '../manifest.js';
import {checkDefined} from '../testing/preconditions.js';
import {SlotComposer} from '../slot-composer.js';
import {handleForStoreInfo} from '../storage/storage.js';
import {EntityType} from '../../types/lib-types.js';
import {Runtime} from '../runtime.js';

describe('Multiplexer', () => {
  it('processes multiple inputs', async () => {
    const manifest = await Manifest.parse(`
      import 'src/runtime/tests/artifacts/Common/Multiplexer.manifest'
      import 'src/runtime/tests/artifacts/test-particles.manifest'

      recipe
        slot0: slot 'rootslotid-slotid'
        handle0: use 'test:1'
        Multiplexer
          hostedParticle: ConsumerParticle
          annotation: consumes slot0
          list: reads handle0
    `, {loader: new Loader(), fileName: ''});

    const recipe = manifest.recipes[0];
    const barType = checkDefined(manifest.findTypeByName('Bar')) as EntityType;
    const slotComposer = new SlotComposer();

    const runtime = new Runtime({context: manifest, loader: new Loader()});
    const arc = runtime.newArc('test');
    const barStore = await arc.createStore(barType.collectionOf(), null, 'test:1');
    const barHandle = await handleForStoreInfo(barStore, arc);
    recipe.handles[0].mapToStorage(barStore);
    assert(recipe.normalize(), 'normalize');
    assert(recipe.isResolved());

    await arc.instantiate(recipe);
    await arc.idle;

    await barHandle.add(new barHandle.entityClass({value: 'one'}));
    await barHandle.add(new barHandle.entityClass({value: 'two'}));
    await barHandle.add(new barHandle.entityClass({value: 'three'}));

    await arc.idle;

    //assert.strictEqual(slotComposer.slotsCreated, 3);
  });
});
