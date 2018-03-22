'use strict'

const offset = [1,2];
const zoom = 2;

const point = { x: 1, y: 1};

const pipeline  = [   // 2D-muunnoksia
    
    function translate(p){
        return { x: p.x + offset[0], y: p.y + offset[1] };
    },

    function scale(p){
        return { x: p.x * zoom, y: p.y * zoom};
    },

    function rotate180(p){
      return {x: -p.x, y: -p.y}
    },
];


function muunnos(point){
     for(let i=0; i<pipeline.length; i++){  
        point = pipeline[i](point);
    }
    return point;
}


console.log(point);
console.log(muunnos(point));