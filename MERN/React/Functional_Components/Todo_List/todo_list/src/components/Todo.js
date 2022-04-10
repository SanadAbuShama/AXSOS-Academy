import React, { useState, useEffect } from "react";

const Todo = () => {
  const [todoList, setTodoList] = useState([]);

  const [newTodo, setNewTodo] = useState("");

  const checkHandler = (e, i) => {
    const newTodoList = [...todoList];
    newTodoList[i].completed = e.target.checked;
    setTodoList(newTodoList);
  };

  const addTodo = (e) => {
    e.preventDefault();
    setTodoList([...todoList, { text: newTodo, completed: false }]);
    setNewTodo("");
  };

  const deleteHandler = (i) => {
    setTodoList(todoList.filter((todo) => todoList.indexOf(todo) !== i));
  };

  useEffect(() => {
    setTodoList(JSON.parse(window.localStorage.getItem("todoList")));
  }, []);

  useEffect(() => {
    window.localStorage.setItem("todoList", JSON.stringify(todoList));
  }, [todoList]);

  return (
    <>
      <div className="row my-5">
        <div className="col-4 offset-4">
          <div className="row">
            <form onSubmit={addTodo}>
              <div className="mb-3">
                <input
                  value={newTodo}
                  type="text"
                  className="form-control"
                  id="exampleFormControlInput1"
                  placeholder="Enter todo"
                  onChange={(e) => setNewTodo(e.target.value)}
                />
              </div>
              <button className="btn btn-primary float-start">Add</button>
            </form>
          </div>
          <div className="row mt-5">
            <ul className="list-group text-start">
              {todoList.map((todo, i) => (
                <li key={i} className="list-group-item">
                  <div className="row align-items-center">
                    <div
                      className="col"
                      style={{
                        textDecoration: todo.completed ? "line-through" : "",
                      }}
                    >
                      {todo.text}
                    </div>
                    <div className="col-1">
                      <input
                        type="checkbox"
                        checked={todo.completed}
                        onChange={(e) => checkHandler(e, i)}
                      />
                    </div>
                    <div className="col-2">
                      <button
                        onClick={() => deleteHandler(i)}
                        className="btn btn-sm btn-dark"
                      >
                        Delete
                      </button>
                    </div>
                  </div>
                </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </>
  );
};

export default Todo;
