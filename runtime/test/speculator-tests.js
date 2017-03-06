/**
 * @license
 * Copyright (c) 2017 Google Inc. All rights reserved.
 * This code may only be used under the BSD style license found at
 * http://polymer.github.io/LICENSE.txt
 * Code distributed by Google as part of this project is also
 * subject to an additional IP rights grant found at
 * http://polymer.github.io/PATENTS.txt
 */

var Speculator = require("../speculator.js");
var data = require("../data-layer.js");
var Arc = require("../arc.js");
var recipe = require("../recipe.js");
let assert = require('chai').assert;

var Foo = data.testing.testEntityClass('Foo');
var Bar = data.testing.testEntityClass('Bar');

describe('speculator', function() {
  beforeEach(function() { data.testing.trash(); });

  it('can speculatively produce a relevance', function() {
    var arc = new Arc();
    var suggestion = new recipe.RecipeBuilder()
        .suggest("TestParticle")
            .connect("foo", data.internals.viewFor(Foo.type))
            .connect("bar", data.internals.viewFor(Bar.type))
        .build();
    var speculator = new Speculator();
    data.internals.viewFor(Foo.type).store(new Foo("not a Bar"));
    var relevance = speculator.speculate(arc, suggestion);
    assert.equal(relevance, 1.8);
    assert.equal(data.internals.viewFor(Bar.type).data.length, 0);
  });
});