import { useState } from "react";

//this is a function that is tied to EACH square of the entire tictactoe board. this does not account for the whole board
//i assume that you create a bunch of these and create a board with it
//kinda demonstrates code reusability, very cool
function Square({ value, onSquareClick }) {
  return (
    <button className="square" onClick={onSquareClick}>
      {value}
    </button>
    //what is this doing?
    //this returns an instance of a square:
    //takes arguments of value and onsquareclick (event)
  );
}

//this is for the entire board!
function Board({ xIsNext, squares, onPlay }) {
  function handleClick(i) {
    if (calculateWinner(squares) || squares[i]) { return; }
    //my guess is this disallows any already taken squares to be overwritten
    const nextSquares = square.slice();
    //what is this slice function?
    //arguments ~.slice(start, end); note: end is optional
    //from my understanding this essentially just segments an array, say you slice by 2, index 2 becomes index 0, the rest before that is ignored. 
    //what is returned is a copy of the array

    if (xIsNext) {
      nextSquares[i] = 'X';
    }
    else {
      nextSquares[i] = 'O';
    }
    onPlay(nextSquares);
    //just tells you who the winner was (x or o)
    const winner = calculateWinner(squares);
    let status;
    if (winner) {
      status = 'Winner: ' + winner;
    }
    else {
      status = 'Next player: ' + (xIsNext ? 'X' : 'O');
    }

    return (
      <>
        <div className="status">{status}</div>
        <div className="board-row">
          <Square value={squares[0]} onSquareClick={() => handleClick(0)} />
          <Square value={squares[1]} onSquareClick={() => handleClick(1)} />
          <Square value={squares[2]} onSquareClick={() => handleClick(2)} />
        </div>
        <div className="board-row">
          <Square value={squares[3]} onSquareClick={() => handleClick(3)} />
          <Square value={squares[4]} onSquareClick={() => handleClick(4)} />
          <Square value={squares[5]} onSquareClick={() => handleClick(5)} />
        </div>
        <div className="board-row">
          <Square value={squares[6]} onSquareClick={() => handleClick(6)} />
          <Square value={squares[7]} onSquareClick={() => handleClick(7)} />
          <Square value={squares[8]} onSquareClick={() => handleClick(8)} />
        </div>
      </>
    );
  }
}

export default function Game() {
  const [history, setHistory] = useState([Array(9).fill(null)]);
  const [currentMove, setCurrentMove] = useState(0);
  const xIsNext = currentMove % 2 === 0;
  const currentSquares = history[currentMove];
  //ok so what are these variables??
  //history is just holds a value
  //setHistory is a setter, i.e this just changes the value of any history value at any time in the array
  //react just creates a new instance of the array and updates it accordingly
  //the rest is pretty self explanatory

  //this function updates the board logic every time a square is pressed, regardless of X or O
  function handlePlay(nextSquares) {
    const nextHistory = [...history.slice(0, currentMove + 1), nextSquares]; //currentmove starts at zero remember
    setHistory(nextHistory); //history is updated in the array
    setCurrentMove(nextHistory.length - 1); //essentially counts how many moves are left...i think
  }

  function jumpTo(nextMove) {
    setCurrentMove(nextMove);
  }

  const moves = history.map((squares, move) => {
    let description;
    if (move > 0){
      description = 'Go to move #' + move;
    }
    else{
      description = 'Go to game start';
    }
    return (
      <li key={move}>
        <button onClick={() => jumpTo(move)}>{description}</button>
      </li>
    )
  })
}

//handles logic to determine the winner
function calculateWinner(squares){
  //hardcoded winner lines
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];

  //wat is this loop doing?
  //it checks "squares (an array)" matches any of the lines
  //if it does that X (or O) is the winner
  for (let i = 0; i < lines.length; i++){
    const[a,b,c] = lines[i];
    if (squares[a] && squares[a] === 
        squares[b] && squares[a] ===
        squares[c]){
          return squares[a];
        }
  }
  return null;
}